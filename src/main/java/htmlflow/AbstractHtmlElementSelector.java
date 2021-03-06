/*
 * MIT License
 *
 * Copyright (c) 2015-16, Mikael KROK
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

package htmlflow;

import htmlflow.attribute.AttrClass;
import htmlflow.attribute.AttrGeneric;
import htmlflow.attribute.AttrId;
import htmlflow.attribute.Attribute;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract base class for all HTML elements.
 *
 * @param <U> The type of HTML element returned by HtmlSelector methods.
 *
 *  @author Mikael KROK
 *         created on 14-01-2016
 */
public abstract class AbstractHtmlElementSelector<U extends AbstractHtmlElementSelector>
        implements HtmlElement<U>, HtmlSelector<U> {
    /*=========================================================================
      -------------------------     FIELDS    ---------------------------------
      =========================================================================*/

    private AttrClass classAttribute;
    private AttrId idAttribute;
    private List<Attribute> attributes;

    /*=========================================================================
      -------------------------  CONSTRUCTOR  ---------------------------------
      =========================================================================*/

    public AbstractHtmlElementSelector() {
        classAttribute = new AttrClass();
        idAttribute = new  AttrId();
        attributes = new LinkedList<>();
        attributes.add(classAttribute);
        attributes.add(idAttribute);

    }
    /*=========================================================================*/
    /*--------------------    Auxiliary Methods    ----------------------------*/
    /*=========================================================================*/

    public final void tabs(PrintStream out, int depth){
        for (int i = 0; i < depth; i++)
            out.print("\t");
    }

    /*=========================================================================*/
    /*--------------------     HtmlElement Methods   ----------------------------*/
    /*=========================================================================*/

    @Override
    public Iterable<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public U addAttr(String name, String value) {
        attributes.add(new AttrGeneric(name, value));
        return (U) this;
    }
    /*=========================================================================*/
    /*--------------------     HtmlSelector Methods   ----------------------------*/
    /*=========================================================================*/

    @Override
    public String getClassAttribute() {
        if(classAttribute.getValue() != null){
            return " class=\""+classAttribute.getValue()+"\"";
        }
        return "";
    }

    @Override
    public String getIdAttribute() {
        if(idAttribute.getValue() != null){
            return " id=\""+idAttribute.getValue()+"\"";
        }
        return "";
    }

    @Override
    public U classAttr(String classAttribute) {
        this.classAttribute.setValue(classAttribute);
        return (U) this;
    }

    @Override
    public  U idAttr(String idAttribute) {
        this.idAttribute.setValue(idAttribute);
        return (U) this;
    }
}
