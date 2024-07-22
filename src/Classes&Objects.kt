fun main() {

    val SmartTvDevice = SmartTvDevice("Samsung Smart TV", deviceCategory = "Entertainment")
    println("This TV is a ${SmartTvDevice.deviceType}. Really good for ${SmartTvDevice.category}")
    SmartTvDevice.turnOn()
    SmartTvDevice.turnOff()
    SmartTvDevice.increaseSpeakerVolume()
    SmartTvDevice.nextChannel()
    println(SmartTvDevice.deviceStatus)

    val SmartLightDevice = SmartLightDevice(" normal flash light", "Tool")
    println("This is a ${SmartLightDevice.deviceType}. A ${SmartLightDevice.category} you need.")
    SmartLightDevice.turnOff()
    SmartLightDevice.turnOn()
    println("Current brightness level is at: ${SmartLightDevice.brightnessLevel}")
    SmartLightDevice.increaseBrightness()
    println("Current brightness level is at: ${SmartLightDevice.brightnessLevel}")
    println(SmartLightDevice.deviceStatus)





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

    fun turnOn() {
        println("Smart device is online.")
    }

    fun turnOff() {
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
        }

class SmartHome (val smartTvDevice: SmartTvDevice){
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
}