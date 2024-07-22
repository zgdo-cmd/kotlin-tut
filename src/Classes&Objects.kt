fun main() {

    var smartDevice: SmartDevice = SmartTvDevice("Androi TV", "Entertainment")
    smartDevice.turnOn()
    smartDevice.turnOff()



}

open class SmartDevice(val deviceType: String, val category: String) {

    var deviceStatus = "online"

    constructor(deviceType: String, category: String, statusCode: Int) : this(deviceType, category) {
        deviceStatus = when(statusCode) {
            0 -> "online"
            1 -> "offline"
            else -> "unknown"
        }

    }

    open fun turnOn() {
        println("Smart device is online.")
    }

    open fun turnOff() {
        println("Smart device is turned offline.")
    }
}


class SmartTvDevice(deviceType: String, deviceCategory: String) :
    SmartDevice(deviceType = deviceType, category = deviceCategory){

        var speakerVolume = 2
            set(value){
                if (value in 0..100){
                    field = value
                }
            }

        var channelNumber = 1
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
            deviceStatus = "on"
            println(
                "$deviceType is turned on. Speaker volume is set to $speakerVolume and channel number is  set to $channelNumber"
            )
        }

        override fun turnOff() {
            deviceStatus = "off"
            println("$deviceType turned off")
        }
}

class SmartLightDevice(deviceType: String, deviceCategory: String) :
        SmartDevice(deviceType = deviceType, category = deviceCategory) {

            var brightnessLevel = 0
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
                deviceStatus = "on"
                brightnessLevel = 2
                println("$deviceType turned on. The brightness level is $brightnessLevel")
            }
            override fun turnOff() {
                deviceStatus = "off"
                brightnessLevel = 0
                println("Smart Light turned off")
            }
        }

class SmartHome (
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
){
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }
    fun turnOffLight() {
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