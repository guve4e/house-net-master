case class Router(className: String, methodName: String, parameters: List[String]) {
  val controllersPath = "controllers."

  def route(): Any = {

    val controllerClass = Class.forName(this.controllersPath + this.className)
    val controllerInstance = controllerClass.getConstructor().newInstance()
    val method = controllerInstance.getClass.getMethod(this.methodName, classOf[List[String]])
    method.invoke(controllerInstance, this.parameters.asInstanceOf[Object])
  }
}

object Test extends App {

  val r = {
    Router("TestController", "testMethod", List("A", "B", "C"))
  }
  r.route()
}