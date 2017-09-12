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

package com.acadiasoft.simm.model.cq;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * As defined in Appendix 1 section E of doc/ISDA-SIMM-v1.3.38.pdf
 */
public class CreditQualifyingRiskWeightV1_3_38 implements CQRiskWeight {

  private static final Map<CreditQualifyingBucket, BigDecimal> WEIGHTS = new HashMap<>();

  static {
    WEIGHTS.put(CreditQualifyingBucket._1, new BigDecimal("83"));
    WEIGHTS.put(CreditQualifyingBucket._2, new BigDecimal("85"));
    WEIGHTS.put(CreditQualifyingBucket._3, new BigDecimal("71"));
    WEIGHTS.put(CreditQualifyingBucket._4, new BigDecimal("48"));
    WEIGHTS.put(CreditQualifyingBucket._5, new BigDecimal("46"));
    WEIGHTS.put(CreditQualifyingBucket._6, new BigDecimal("42"));
    WEIGHTS.put(CreditQualifyingBucket._7, new BigDecimal("160"));
    WEIGHTS.put(CreditQualifyingBucket._8, new BigDecimal("229"));
    WEIGHTS.put(CreditQualifyingBucket._9, new BigDecimal("149"));
    WEIGHTS.put(CreditQualifyingBucket._10, new BigDecimal("207"));
    WEIGHTS.put(CreditQualifyingBucket._11, new BigDecimal("138"));
    WEIGHTS.put(CreditQualifyingBucket._12, new BigDecimal("99"));
    WEIGHTS.put(CreditQualifyingBucket.RESIDUAL, new BigDecimal("229"));
  }

  private static final BigDecimal VEGA = new BigDecimal("0.27");

  @Override
  public BigDecimal getRiskWeight(Sensitivity s) {
    return WEIGHTS.get(CreditQualifyingBucket.getBucket(s.getBucket()));
  }

  @Override
  public BigDecimal getVegaRiskWeight(Sensitivity s) {
    return VEGA;
  }

  @Override
  public BigDecimal getHVR() {
    return BigDecimal.ONE;
  }
}
