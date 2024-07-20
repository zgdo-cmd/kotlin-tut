fun main() {
    val SmartDevice = SmartDevice()

    println("Device type is: ${SmartDevice.deviceType}")
    println("The Device is for: ${SmartDevice.category}")
    SmartDevice.turnOn()
    SmartDevice.turnOff()
}

class SmartDevice() {
    val deviceType = "SmartTV"
    val category = "Entertainment"
    var deviceStatus = "online"


    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }



}