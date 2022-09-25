//> using file "../../modules/platform/src"

import toolkit.json
import toolkit.os
import toolkit.http.*

@main def a = 
  val req = http.request.post(uri"http://ptsv2.com/t/sttp/post").body(Data("ala", 12, Nil))
  http.client.send(req)
  println("Done")
  println(uri"http://ptsv2.com/t/sttp/post".get().body)
  

case class Data(name: String, age: Int, rooms: Seq[String]) derives json.ReadWriter

