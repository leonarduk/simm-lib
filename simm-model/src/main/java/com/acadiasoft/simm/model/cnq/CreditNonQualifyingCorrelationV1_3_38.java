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

package com.acadiasoft.simm.model.cnq;

import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * As defined in Appendix 1 section F of doc/ISDA_SIMM_vR1.0_(PUBLIC).pdf
 */
public class CreditNonQualifyingCorrelationV1_3_38 implements CNRiskCorrelation {

  public static final BigDecimal AGGREGATE_SAME = new BigDecimal("0.57");
  public static final BigDecimal AGGREGATE_DIFF = new BigDecimal("0.27");
  public static final BigDecimal RESIDUAL = new BigDecimal("0.50");
  public static final BigDecimal NON_RESIDUAL_TO_NON_RESIDUAL = new BigDecimal("0.21");

  @Override
  public BigDecimal getSensitivityCorrelation(Sensitivity si, Sensitivity sk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, si.getBucket()) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, sk.getBucket())) {
      return RESIDUAL;
    } else if (StringUtils.equals(si.getQualifier(), sk.getQualifier())) {
      return AGGREGATE_SAME;
    } else {
      return AGGREGATE_DIFF;
    }
  }

  @Override
  public BigDecimal getBucketCorrelation(String bi, String bk) {
    if (StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bi) || StringUtils.equalsIgnoreCase(Sensitivity.RESIDUAL, bk)) {
      throw new RuntimeException("called bucket correlation for a residual bucket: " + bi + ", " + bk);
    } else {
      return NON_RESIDUAL_TO_NON_RESIDUAL;
    }
  }
}
