package eslam.emad.androidunittesting

import android.content.Context

class StringComparer {

    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}