fun main() {
//    val SmartDevice = SmartDevice(deviceType = "Smart TV", category = "Entertainment")
    val SmartDevice = SmartDevice(deviceType = "Smart TV", category = "Entertainment", 2)

//    println("Device type is: ${SmartDevice.deviceType}")
//    println("The Device is for: ${SmartDevice.category}")

}

class SmartDevice(val deviceType: String, val category: String) {

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