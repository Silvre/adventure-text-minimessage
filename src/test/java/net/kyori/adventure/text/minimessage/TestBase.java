/*
 * This file is part of adventure-text-minimessage, licensed under the MIT License.
 *
 * Copyright (c) 2018-2020 KyoriPowered
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
package net.kyori.adventure.text.minimessage;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBase {

  final MiniMessage PARSER = MiniMessage.builder().strict(true).build();

  void assertParsedEquals(final @NonNull Component expected, final @NonNull String input) {
    this.assertParsedEquals(this.PARSER, expected, input);
  }

  void assertParsedEquals(final @NonNull Component expected, final @NonNull String input, final @NonNull Object... args) {
    this.assertParsedEquals(this.PARSER, expected, input, args);
  }

  void assertParsedEquals(final MiniMessage miniMessage, final Component expected, final String input) {
    System.out.println("exp : " + GsonComponentSerializer.gson().serialize(expected));
    System.out.println("prov: " + GsonComponentSerializer.gson().serialize(miniMessage.parse(input)));
    assertEquals(expected, miniMessage.parse(input));
  }

  void assertParsedEquals(final MiniMessage miniMessage, final Component expected, final String input, final @NonNull Object... args) {
    System.out.println("exp : " + GsonComponentSerializer.gson().serialize(expected));
    System.out.println("prov: " + GsonComponentSerializer.gson().serialize(miniMessage.parse(input, args)));
    assertEquals(expected, miniMessage.parse(input, args));
  }
}