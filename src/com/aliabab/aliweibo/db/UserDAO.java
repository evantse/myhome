package com.aliabab.aliweibo.db;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;



import com.aliabab.aliweibo.pojo.UserDO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class UserDAO {
    private DBHelper dbHelper = null;
    private SQLiteDatabase db = null;
    private ContentValues values = null;
    private String[] columns = { UserDO.ID,UserDO.TOKEN,UserDO.NICK_NAME,UserDO.ICON,UserDO.PERSON_ID};
    
    public UserDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    
    public long insertUserDO(UserDO user) {

        db = dbHelper.getWritableDatabase();

        values = new ContentValues(5);

        values.put(UserDO.ID, user.getId());
        values.put(UserDO.NICK_NAME, user.getNickName());
        values.put(UserDO.PERSON_ID, user.getPersonId());
        values.put(UserDO.TOKEN, user.getPersonId());
        if(user.getIcon() !=null){
         // BLOB类型 
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            BitmapDrawable newImage = (BitmapDrawable) user.getIcon();
            // 将Bitmap压缩成PNG编码，质量为100%存储
            newImage.getBitmap().compress(CompressFormat.PNG, 100, os);
            // 构造SQLite的Content对象，这里也可以使用raw
            values.put(UserDO.ICON, os.toByteArray());    
        }
        long rowId = db.insert(UserDO.TB_NAME, null, values);

        db.close();
        

        return rowId;
    }

	public List<UserDO> findAllUsers() {
		 db = this.dbHelper.getReadableDatabase();

	        List<UserDO> users = null;

	        Cursor cursor = db.query(UserDO.TB_NAME, columns, null, null, null,
	                null, null);

	        if (null != cursor && cursor.getCount() > 0) {

	            users = new ArrayList<UserDO>(cursor.getCount());

	            UserDO userDO = null;
	            while (cursor.moveToNext()) {
	            	userDO = new UserDO();
	                Long id = cursor.getLong(cursor.getColumnIndex(UserDO.ID));
	                String personId = cursor.getString(cursor
	                        .getColumnIndex(UserDO.PERSON_ID));
	                String token = cursor.getString(cursor
	                        .getColumnIndex(UserDO.TOKEN));
	                String nickName = cursor.getString(cursor
	                        .getColumnIndex(UserDO.NICK_NAME));
	                byte[] byteIcon = cursor.getBlob(cursor
	                        .getColumnIndex(UserDO.ICON));

	                userDO.setId(id);
	                userDO.setNickName(nickName);
	                userDO.setPersonId(personId);
	                userDO.setToken(token);
	                if (null != byteIcon) {
	                    ByteArrayInputStream is = new ByteArrayInputStream(byteIcon);
	                    Drawable userIcon = Drawable.createFromStream(is, "image");
	                    userDO.setIcon(userIcon);
	                }
	                users.add(userDO);
	            }
	        }
	        cursor.close();
	        db.close();
	        return users;
	}
}
