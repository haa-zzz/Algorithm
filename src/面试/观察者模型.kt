package 面试

object Observer{
    interface IObserver {
        fun update()

    }
    interface IOwner {
        fun addObserver(observer: IObserver)
        fun removerObserver(observer: IObserver)
        fun notifyObserver()
    }
    class DemoObserver: IObserver {
        override fun update() {

        }

    }
    class DemoIOwner: IOwner {
        val list = mutableListOf<IObserver>()
        override fun addObserver(observer: IObserver) {
            list.add(observer)
        }

        override fun removerObserver(observer: IObserver) {
            list.remove(observer)
        }

        override fun notifyObserver() {
            list.forEach {
                it.update()
            }
        }
    }
}
