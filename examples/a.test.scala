import toolkit.test
import toolkit.json

class Atest extends test.Suite {
  test("Data reserialization"){
    val data = Data("Ala", 31, Seq("main", "kitchen"))
    // TODO implicit problems with `read` method
    assertEquals(data, json.read[Data](json.write(data)))
  }
}