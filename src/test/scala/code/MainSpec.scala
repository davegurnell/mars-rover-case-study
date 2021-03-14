package code

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MainSpec extends AnyWordSpec with Matchers {
  "true" should {
    "equal false" in {
      true shouldBe false
    }
  }
}
