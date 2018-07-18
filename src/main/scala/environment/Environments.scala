package environment


import com.google.common.collect.Maps
import scala.beans.BeanProperty

class Environments {
  @BeanProperty var environments: java.util.Map[String, Environment] = Maps.newHashMap[String, Environment] ()
}


class Environment {
  @BeanProperty var url: String = null
  @BeanProperty var mainPort: Int = 7990
  @BeanProperty var bank01InPort: Int = 7991
  @BeanProperty var bank02InPort: Int = 7992
  @BeanProperty var bank01OutPort: Int = 7991
  @BeanProperty var bank02OutPort: Int = 7992
}