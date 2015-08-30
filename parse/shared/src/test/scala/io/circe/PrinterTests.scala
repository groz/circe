package io.circe

import io.circe.test.{ PrinterTests, CirceSuite }

/**
 * Tests for [[io.circe.Printer]].
 *
 * This isn't the ideal place for these tests, but we don't have a parser available in the core
 * package, and it's not possible to include e.g. an Argonaut dependency there if we want to support
 * Scala.js testing
 */
class PrinterSuite(printer: Printer) extends CirceSuite {
  checkAll("Printing Unit", PrinterTests[Unit].printer(printer, parse.`package`))
  checkAll("Printing Boolean", PrinterTests[Boolean].printer(printer, parse.`package`))
  checkAll("Printing Char", PrinterTests[Char].printer(printer, parse.`package`))
  checkAll("Printing Float", PrinterTests[Float].printer(printer, parse.`package`))
  checkAll("Printing Double", PrinterTests[Double].printer(printer, parse.`package`))
  checkAll("Printing Short", PrinterTests[Short].printer(printer, parse.`package`))
  checkAll("Printing Int", PrinterTests[Int].printer(printer, parse.`package`))
  checkAll("Printing Long", PrinterTests[Long].printer(printer, parse.`package`))
  checkAll("Printing Map", PrinterTests[Map[String, List[Int]]].printer(printer, parse.`package`))
}

class NoSpacesPrinterTests extends PrinterSuite(Printer.noSpaces)
class Spaces2PrinterTests extends PrinterSuite(Printer.noSpaces)
class Spaces4PrinterTests extends PrinterSuite(Printer.spaces4)
