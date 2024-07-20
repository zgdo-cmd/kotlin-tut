class SmartDevice() {
    val deviceType = "Smart TV"
    val category = "Entertainment"
    var deviceStatus = "online"
    fun turnOn() {
        println("Smart device is turned on.")
    }
    fun turnOff() {
        println("Smart device is turned on.")
    }
}

fun main() {
    val SmartDevice = SmartDevice()
    println("Device type is: ${SmartDevice.deviceType}")
    SmartDevice.turnOn()
    SmartDevice.turnOff()
}