package programs.threads

// object is enough to have thread safe singleton
// but if you want to pass params then below helper will help
// Credit source - https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e
open class SingletonHolder<out T: Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}
// usage
/**
 *  class Manager private constructor(context: Context) {
 *  init {
 *  // Init using context argument
 *  }
 *  companion object : SingletonHolder<Manager, Context>(::Manager)
 *  }
*/

/**
 * Then
 *   Manager.getInstance(context).doStuff()
 */