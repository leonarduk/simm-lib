/*
 * Copyright (c) 2017 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.simm.model.risk;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.acadiasoft.simm.model.risk.RiskClass.*;
import static com.acadiasoft.simm.model.risk.RiskClassCorrelation.get;

public class RiskClassCorrelationTest {

  @Test
  public void getCorrelationTest() {
    Assert.assertEquals(new BigDecimal("1"), get(INTEREST_RATE, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.28"), get(INTEREST_RATE, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.14"), get(INTEREST_RATE, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.18"), get(INTEREST_RATE, EQUITY));
    Assert.assertEquals(new BigDecimal("0.30"), get(INTEREST_RATE, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.17"), get(INTEREST_RATE, FX));
    Assert.assertEquals(new BigDecimal("0.28"), get(CREDIT_QUALIFYING, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("1"), get(CREDIT_QUALIFYING, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.58"), get(CREDIT_QUALIFYING, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.66"), get(CREDIT_QUALIFYING, EQUITY));
    Assert.assertEquals(new BigDecimal("0.46"), get(CREDIT_QUALIFYING, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.27"), get(CREDIT_QUALIFYING, FX));
    Assert.assertEquals(new BigDecimal("0.14"), get(CREDIT_NON_QUALIFYING, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.58"), get(CREDIT_NON_QUALIFYING, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("1"), get(CREDIT_NON_QUALIFYING, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.42"), get(CREDIT_NON_QUALIFYING, EQUITY));
    Assert.assertEquals(new BigDecimal("0.27"), get(CREDIT_NON_QUALIFYING, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.14"), get(CREDIT_NON_QUALIFYING, FX));
    Assert.assertEquals(new BigDecimal("0.18"), get(EQUITY, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.66"), get(EQUITY, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.42"), get(EQUITY, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("1"), get(EQUITY, EQUITY));
    Assert.assertEquals(new BigDecimal("0.39"), get(EQUITY, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.24"), get(EQUITY, FX));
    Assert.assertEquals(new BigDecimal("0.30"), get(COMMODITY, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.46"), get(COMMODITY, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.27"), get(COMMODITY, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.39"), get(COMMODITY, EQUITY));
    Assert.assertEquals(new BigDecimal("1"), get(COMMODITY, COMMODITY));
    Assert.assertEquals(new BigDecimal("0.32"), get(COMMODITY, FX));
    Assert.assertEquals(new BigDecimal("0.17"), get(FX, INTEREST_RATE));
    Assert.assertEquals(new BigDecimal("0.27"), get(FX, CREDIT_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.14"), get(FX, CREDIT_NON_QUALIFYING));
    Assert.assertEquals(new BigDecimal("0.24"), get(FX, EQUITY));
    Assert.assertEquals(new BigDecimal("0.32"), get(FX, COMMODITY));
    Assert.assertEquals(new BigDecimal("1"), get(FX, FX));
  }
}
