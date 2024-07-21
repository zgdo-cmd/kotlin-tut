fun main() {
    val SmartDevice = SmartDevice(deviceType = "Smart TV", category = "Entertainment")

    println("Device type is: ${SmartDevice.deviceType}")
    println("The Device is for: ${SmartDevice.category}")
    SmartDevice.turnOn()
    SmartDevice.turnOff()
}

class SmartDevice(val deviceType: String, val category: String) {

    var deviceStatus = "online"

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }

}