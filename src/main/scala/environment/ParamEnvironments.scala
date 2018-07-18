package environment


import com.google.common.collect.Maps

import scala.beans.BeanProperty
import scala.collection.JavaConverters._

class ParamEnvironments {
  @BeanProperty var paramEnvironments: java.util.Map[String, ParamEnvironment] = Maps.newHashMap[String, ParamEnvironment]()
}


class ParamEnvironment {
  @BeanProperty var url: String = null
  @BeanProperty var mainPort: Int = 7990
  @BeanProperty var bank01InPort: Int = 7991
  @BeanProperty var bank02InPort: Int = 7992
  @BeanProperty var bank01OutPort: Int = 7991
  @BeanProperty var bank02OutPort: Int = 7992
}