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
package net.kyori.adventure.text.minimessage.markdown;

public class DiscordFlavor implements MarkdownFlavor {

    private DiscordFlavor() {
    }

    public static MarkdownFlavor get() {
        return new DiscordFlavor();
    }

    @Override
    public boolean isBold(char current, char next) {
        return (current == '*' && next == current);
    }

    @Override
    public boolean isItalic(char current, char next) {
        return (current == '*' && next != current);
    }

    @Override
    public boolean isUnderline(char current, char next) {
        return current == '_' && next == current;
    }

    @Override
    public boolean isStrikeThrough(char current, char next) {
        return current == '~' && next == current;
    }

    @Override
    public boolean isObfuscate(char current, char next) {
        return current == '|' && next == current;
    }
}