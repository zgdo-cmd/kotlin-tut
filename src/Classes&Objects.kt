fun main() {
//    val SmartDevice = SmartDevice(deviceType = "Smart TV", category = "Entertainment")
    val SmartDevice = SmartDevice(deviceType = "Smart TV", category = "Entertainment", 2)

//    println("Device type is: ${SmartDevice.deviceType}")
//    println("The Device is for: ${SmartDevice.category}")

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
        println(deviceStatus)

    }
}


class SmartTvDevice(deviceType: String, deviceCategory: CharCategory) :
    SmartDevice(deviceType = deviceType, category = deviceType){

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
