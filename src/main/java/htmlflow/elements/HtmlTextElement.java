/*
 * MIT License
 *
 * Copyright (c) 2014-16, Miguel Gamboa (gamboa.pt)
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
package htmlflow.elements;

import htmlflow.HtmlWriterComposite;
import htmlflow.ModelBinder;
import htmlflow.TextNode;

/**
 * @author Miguel Gamboa
 *         created on 29-03-2012
 */
public abstract class HtmlTextElement<T> extends HtmlWriterComposite<T, HtmlTextElement>{

    public final void text(String msg){addChild(new TextNode<T>(msg)); }
    public final void text(ModelBinder<T, ?> binder){addChild(new TextNode<T>(binder));}

    protected final String element;

    public HtmlTextElement() {
      element = "";
    }

    public HtmlTextElement(String element) {
        this.element = element;
    }

    @Override
    public String getElementName(){
        return  element;
    }

}
