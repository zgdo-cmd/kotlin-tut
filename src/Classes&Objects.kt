fun main() {

    var smartDevice: SmartDevice = SmartTvDevice("Androi TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.turnOff()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
    smartDevice.turnOff()

}

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set(value) {
            field = value
        }

    open val deviceType = "unknown"

    constructor(deviceType: String, category: String, statusCode: Int) : this(deviceType, category) {
        deviceStatus = when(statusCode) {
            0 -> "online"
            1 -> "offline"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}


class SmartTvDevice(name: String, category: String) :
    SmartDevice(name = name, category = category){

        override val deviceType = "Smart Tv"

        private var speakerVolume = 2
            set(value){
                if (value in 0..100){
                    field = value
                }
            }

        private var channelNumber = 1
            set(value) {
                if (value in 0..200) {
                    field = value
                }
            }

        fun increaseSpeakerVolume() {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        }

        fun nextChannel() {
            channelNumber++
            println("Channel number increased to $channelNumber")
        }

        override fun turnOn() {
            super.turnOn()
            println(
                "$name is turned on. Speaker volume is set to $speakerVolume and channel number is  set to $channelNumber"
            )
        }

        override fun turnOff() {
            super.turnOff()
            println("$name turned off")
        }
}

class SmartLightDevice(name: String, category: String) :
        SmartDevice(name = name, category = category) {

            override val deviceType = "Smart Light"

            private var brightnessLevel = 0
                set(value) {
                    if (value in 0..100){
                        field = value
                    }
                }

            fun increaseBrightness() {
                brightnessLevel++
                println("Brightness increased to $brightnessLevel")
            }

            override fun turnOn() {
                super.turnOn()
                brightnessLevel = 2
                println("$name turned on. The brightness level is $brightnessLevel")
            }
            override fun turnOff() {
                super.turnOff()
                brightnessLevel = 0
                println("Smart Light turned off")
            }
        }

class SmartHome (
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
){
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    fun turnOffLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOfAllDevices() {
        turnOffTv()
        turnOffLight()
    }

}