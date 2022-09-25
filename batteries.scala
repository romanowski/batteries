//> using lib "com.lihaoyi::ujson:2.0.0"
//> using lib "com.lihaoyi::upickle:2.0.0"
//> using lib "com.lihaoyi::os-lib:0.8.1"
//> using lib "com.softwaremill.sttp.client3::upickle:3.8.0"


package scala.toolkit {
import _root_.{os => osLib}
import munit.FunSuite
import junit.framework.TestSuite
import sttp.client3.upicklejson.SttpUpickleApi

  val json = upickle.default 
  object os {
    export osLib.pwd 
  }
  

  object test {
    export munit.{FunSuite => Suite}
  }

  object http extends SttpUpickleApi{

    val http = this

    val request = sttp.client3.basicRequest
    //val x: UriContext = ???
    export sttp.client3.UriContext

    export sttp.client3.{SimpleHttpClient => Client}

    def client = Client()

    extension (uri: sttp.model.Uri)
      def get() = client.send(request.get(uri))
  }
  
}

