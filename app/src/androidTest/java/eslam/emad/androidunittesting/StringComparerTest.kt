package eslam.emad.androidunittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class StringComparerTest{

    private lateinit var stringComparer: StringComparer

    @Before
    fun setup() {
        stringComparer = StringComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringComparer.isEqual(context, R.string.app_name, "Android Unit Testing")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = stringComparer.isEqual(context, R.string.app_name, "Hello")
        assertThat(result).isFalse()
    }
}