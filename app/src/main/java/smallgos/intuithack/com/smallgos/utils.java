package smallgos.intuithack.com.smallgos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

public class Utils {

    public static Drawable convertBase64ToDrawable(Context context, String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return new BitmapDrawable(context.getResources(), bitmap);
    }
}
