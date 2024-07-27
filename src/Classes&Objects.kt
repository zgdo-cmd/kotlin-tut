import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class RangeRegulator(

    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue){
            fieldData = value
        }
    }

}

fun main() {

//    var smartDevice: SmartDevice = SmartTvDevice("Androi TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()

    var smartHome = SmartHome(SmartTvDevice("Android Tv", "Entertainment"), SmartLightDevice("Google Light", "Utility"))
    smartHome.decreaseLightBrightness()

}

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
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

    fun printDeviceInfo(){
        print("Device name: $name, category: $category, type: $deviceType")
    }
}


class SmartTvDevice(name: String, category: String) :
    SmartDevice(name = name, category = category){

        override val deviceType = "Smart Tv"

        private var speakerVolume by RangeRegulator(1, 0, 100)
        private var channelNumber by RangeRegulator(1, 0, 200)

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

        fun decreaseVolume() {
            speakerVolume--
        }

        fun previousChannel() {
            channelNumber--
        }
}

class SmartLightDevice(name: String, category: String) :
        SmartDevice(name = name, category = category) {

            override val deviceType = "Smart Light"

            private var brightnessLevel by RangeRegulator(1, 0, 100)

            fun increaseBrightness() {
                brightnessLevel++
                println("Brightness increased to $brightnessLevel")
            }

            override fun turnOn() {
                super.turnOn()
                brightnessLevel = 1
                println("$name turned on. The brightness level is $brightnessLevel")
            }
            override fun turnOff() {
                super.turnOff()
                brightnessLevel = 0
                println("Smart Light turned off")
            }

            fun decreaseBrightness() {
                brightnessLevel--
            }
        }

class SmartHome (
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
){


//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        deviceTurnOnCount++
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        deviceTurnOnCount--
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        deviceTurnOnCount++
//        smartLightDevice.turnOn()
//    }
//    fun turnOffLight() {
//        deviceTurnOnCount++
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOfAllDevices() {
//        turnOffTv()
//        turnOffLight()
//    }

    fun decreaseTvVolume() {
        if(smartTvDevice.deviceStatus == "on"){
            smartTvDevice.decreaseVolume()
        }
    }

    fun previousTvChannel() {
        if (smartLightDevice.deviceStatus == "on"){
            smartTvDevice.previousChannel()
        }
    }

    fun decreaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "on"){
            smartLightDevice.decreaseBrightness()
        }else{
            println("You can't do that shit")
        }
    }
}


