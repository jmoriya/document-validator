/**
 * redpen: a text inspection tool
 * Copyright (C) 2014 Recruit Technologies Co., Ltd. and contributors
 * (see CONTRIBUTORS.md)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.unigram.docvalidator.validator.section;

import org.junit.Test;
import org.unigram.docvalidator.model.Paragraph;
import org.unigram.docvalidator.model.Section;
import org.unigram.docvalidator.ValidationError;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParagraphStartWithValidatorTest {

  @Test
  public void testStartWithoutSpace() {
    ParagraphStartWithValidator validator = new ParagraphStartWithValidator();
    Section section = new Section(0, "header");
    Paragraph paragraph = new Paragraph();
    paragraph.appendSentence("it like a piece of a cake.", 0);
    section.appendParagraph(paragraph);
    List<ValidationError> errors = validator.validate(section);
    assertEquals(1, errors.size());
  }

  @Test
  public void testStartWithSpace() {
    ParagraphStartWithValidator validator = new ParagraphStartWithValidator();
    Section section = new Section(0);
    Paragraph paragraph = new Paragraph();
    paragraph.appendSentence(" it like a piece of a cake.", 0);
    section.appendParagraph(paragraph);
    List<ValidationError> errors = validator.validate(section);
    assertEquals(0, errors.size());
  }

}
