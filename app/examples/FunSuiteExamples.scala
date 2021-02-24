/**
 * Copyright 2010-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package examples

object FunSuiteExamples extends StyleTraitExamples {

  val name: String = "FunSuite"

  val description: String = """For teams coming from xUnit, FunSuite feels comfortable and familiar while still giving some of the benefits of BDD: FunSuite makes it easy to write descriptive test names, natural to write focused tests, and generates specification-like output that can facilitate communication among stakeholders."""

/*
  val exampleUsage: String =
    """<span class="stImport">import org.scalatest.FunSuite</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  test(<span class="stLiteral">"An empty Set should have size 0"</span>) { assert(<span class="stType">Set</span>.empty.size === <span class="stLiteral">0</span>) }
      |  test(<span class="stLiteral">"Invoking head on an empty Set should produce NoSuchElementException"</span>) {
      |    intercept[<span class="stType">NoSuchElementException</span>] { <span class="stType">Set</span>.empty.head }
      |  }
      |} """.stripMargin
*/
  val exampleUsage: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stImport">import funsuite._</span>
      |
      |<span class="stReserved">class</span> <span class="stType">SetSpec</span> <span class="stReserved">extends</span> <span class="stType">AnyFunSuite</span> {
      |  <span class="stReserved">override</span> <span class="stReserved">def</span> withFixture(test: <span class="stType">NoArgTest</span>) = { <span class="stExplain">// Define a shared fixture</span>
      |    <span class="stExplain">// Shared setup (run at beginning of each test)</span>
      |    <span class="stReserved">try</span> test()
      |    <span class="stReserved">finally</span> {
      |      <span class="stExplain">// Shared cleanup (run at end of each test)</span>
      |    }
      |  }
      |  <span class="stExplain">// Define tests with 'test', a test name string in parentheses,
      |  // and test body in curly braces</span>
      |  test(<span class="stLiteral">"An empty Set should have size 0"</span>) {
      |    assert(<span class="stType">Set</span>.empty.size == <span class="stLiteral">0</span>)
      |  }
      |  <span class="stExplain">// To ignore a test, change 'test' to 'ignore'</span>
      |  ignore(<span class="stLiteral">"Invoking head on an empty Set should produce NoSuchElementException"</span>) {
      |    intercept[<span class="stType">NoSuchElementException</span>] {
      |      <span class="stType">Set</span>.empty.head
      |    }
      |  }
      |  <span class="stExplain">// Define a pending test by using (pending) for the body</span>
      |  test(<span class="stLiteral">"An empty Set's isEmpty method should return false"</span>) (pending)
      |  <span class="stExplain">// Tag a test by placing a tag object after the test name</span>
      |  <span class="stImport">import tagobjects.Slow</span>
      |  test(<span class="stLiteral">"An empty Set's nonEmpty method should return true"</span>, Slow) { 
      |    assert(!<span class="stType">Set</span>.empty.nonEmpty)
      |  }
      |}
      |
      |<span class="stExplain">// Can also pass fixtures into tests with FixtureAnyFunSuite</span>
      |<span class="stReserved">class</span> <span class="stType">StringSpec</span> <span class="stReserved">extends</span> <span class="stType">FixtureAnyFunSuite</span> {
      |  <span class="stReserved">type</span> FixtureParam = <span class="stType">String</span> <span class="stExplain">// Define the type of the passed fixture object</span>
      |  <span class="stReserved">override</span> <span class="stReserved">def</span> withFixture(test: <span class="stType">OneArgTest</span>) = {
      |    <span class="stExplain">// Shared setup (run before each test), including...</span>
      |    <span class="stReserved">val</span> fixture = <span class="stLiteral">"a fixture object"</span> <span class="stExplain">// ...creating a fixture object</span>
      |    <span class="stReserved">try</span> test(fixture) <span class="stExplain">// Pass the fixture into the test</span>
      |    <span class="stReserved">finally</span> {
      |      <span class="stExplain">// Shared cleanup (run at end of each test)</span>
      |    }
      |  }
      |  test(<span class="stLiteral">"The passed fixture can be used in the test"</span>) { s =&gt; <span class="stExplain">// Fixture passed in as s</span>
      |    assert(s == <span class="stLiteral">"a fixture object"</span>)
      |  }
      |}
      |
      |@DoNotDiscover <span class="stExplain">// Disable discovery of a test class</span>
      |<span class="stReserved">class</span> <span class="stType">InvisibleSpec</span> <span class="stReserved">extends</span> <span class="stType">AnyFunSuite</span> { <span class="stBlockComment">/*code omitted*/</span> }
      |
      |@Ignore <span class="stExplain">// Ignore all tests in a test class</span>
      |<span class="stReserved">class</span> <span class="stType">IgnoredSpec</span> <span class="stReserved">extends</span> <span class="stType">AnyFunSuite</span> { <span class="stBlockComment">/*code omitted*/</span> }
      |
      |<span class="stImport">import tags.Slow</span>
      |@Slow <span class="stExplain">// Mark all tests in a test class with a tag</span>
      |<span class="stReserved">class</span> <span class="stType">SlowSpec</span> <span class="stReserved">extends</span> <span class="stType">AnyFunSuite</span> { <span class="stBlockComment">/*code omitted*/</span> }
      |""".stripMargin

  val play2Example: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stImport">import play.api.test._</span>
      |<span class="stImport">import play.api.test.Helpers._</span>
      |
      |<span class="stReserved">class</span> <span class="stType">ExampleSpec</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> <span class="stReserved">with</span> <span class="stType">Matchers</span> {
      |  test(<span class="stLiteral">"Application should send 404 on a bad request"</span>)  {
      |    running(<span class="stType">FakeApplication</span>()) { route(<span class="stType">FakeRequest</span>(GET, "/boum")) shouldBe <span class="stType">None</span> }
      |  }
      |  test(<span class="stLiteral">"Application should send render the index page"</span>) {
      |    running(<span class="stType">FakeApplication</span>()) {
      |      <span class="stReserved">val</span> home = route(<span class="stType">FakeRequest</span>(GET, <span class="stLiteral">"/"</span>)).get
      |      status(home) shouldBe OK
      |      contentType(home) shouldBe <span class="stType">Some</span>(<span class="stLiteral">"text/html"</span>)
      |      contentAsString(home) should include (<span class="stLiteral">"ScalaTest"</span>)
      |    }
      |  }
      |}""".stripMargin

  val doNotDiscover: String =
    """<span class="stImport">import org.scalatest._</span>
      |@DoNotDiscover
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> { <span class="stBlockComment">/*code omitted*/</span> }
    """.stripMargin

  val ignoreTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  ignore(<span class="stLiteral">"An empty Set should have size 0"</span>) { <span class="stBlockComment">/*code omitted*/</span> }
      |}""".stripMargin

  val pendingTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  test(<span class="stLiteral">"An empty Set should have size 0"</span>) (pending)
      |}""".stripMargin

  val taggingTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">object</span> <span class="stType">SlowTest</span> <span class="stReserved">extends</span> <span class="stType">Tag</span>(<span class="stLiteral">"com.mycompany.tags.SlowTest"</span>)
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  test(<span class="stLiteral">"An empty Set should have size 0"</span>, <span class="stType">SlowTest</span>) {
      |    <span class="stBlockComment">/*code omitted*/</span>
      |  }
      |}""".stripMargin

  val infoTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  test(<span class="stLiteral">"An empty Set should have size 0"</span>) {
      |    info(<span class="stLiteral">"Some information."</span>)
      |    <span class="stBlockComment">/*code omitted*/</span>
      |  }
      |}""".stripMargin

  val fixtureNoArgTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> {
      |  <span class="stReserved">def</span> setup() { <span class="stBlockComment">/*code omitted*/</span> }
      |  <span class="stReserved">def</span> cleanup() { <span class="stBlockComment">/*code omitted*/</span> }
      |  <span class="stReserved">override</span> <span class="stReserved">protected</span> <span class="stReserved">def</span> withFixture(test: <span class="stType">NoArgTest</span>) = {
      |    setup()
      |    <span class="stReserved">try</span> test() <span class="stReserved">finally</span> cleanup()
      |  }
      |}""".stripMargin

  val fixtureOneArgTest: String =
    """<span class="stImport">import org.scalatest._</span>
      |<span class="stReserved">class</span> <span class="stType">SetSuite</span> <span class="stReserved">extends</span> <span class="stType">fixture.FunSuite</span> {
      |  <span class="stReserved">def</span> setup() { <span class="stBlockComment">/*code omitted*/</span> }
      |  <span class="stReserved">def</span> cleanup() { <span class="stBlockComment">/*code omitted*/</span> }
      |  <span class="stReserved">type</span> FixtureParam = <span class="stType">String</span>
      |  <span class="stReserved">override</span> <span class="stReserved">protected</span> <span class="stReserved">def</span> withFixture(test: <span class="stType">OneArgTest</span>) = {
      |    setup()
      |    <span class="stReserved">try</span> test(<span class="stLiteral">"this is a fixture param"</span>) <span class="stReserved">finally</span> cleanup()
      |  }
      |}""".stripMargin

  val seleniumExample: String =
    """<span class="stImport">import org.scalatest._
      |import selenium._</span>
      |<span class="stReserved">class</span> <span class="stType">BlogSpec</span> <span class="stReserved">extends</span> <span class="stType">FunSuite</span> <span class="stReserved">with</span> <span class="stType">WebBrowser</span> <span class="stReserved">with</span> <span class="stType">HtmlUnit</span> {
      |  <span class="stReserved">val</span> host = <span class="stLiteral">"http://localhost:9000/"</span>
      |  test(<span class="stLiteral">"The blog app home page should have the correct title"</span>) {
      |    go to (host + <span class="stLiteral">"index.html"</span>)
      |    pageTitle should be (<span class="stLiteral">"Awesome Blog"</span>)
      |  }
      |}""".stripMargin
}
