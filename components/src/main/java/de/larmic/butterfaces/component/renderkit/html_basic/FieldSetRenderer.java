package de.larmic.butterfaces.component.renderkit.html_basic;

import de.larmic.butterfaces.component.html.HtmlFieldSet;
import de.larmic.butterfaces.component.partrenderer.StringUtils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import java.io.IOException;

/**
 * Created by larmic on 31.07.14.
 */
@FacesRenderer(componentFamily = HtmlFieldSet.COMPONENT_FAMILY, rendererType = HtmlFieldSet.RENDERER_TYPE)
public class FieldSetRenderer extends com.sun.faces.renderkit.html_basic.HtmlBasicRenderer {

    public static final String ELEMENT_FIELDSET = "fieldset";
    public static final String ATTRIBUTE_STYLE = "style";
    public static final String ATTRIBUTE_CLASS = "class";
    public static final String ELEMENT_LEGEND = "legend";
    public static final String ELEMENT_SPAN = "span";

    @Override
    public void encodeBegin(final FacesContext context, final UIComponent component) throws IOException {
        rendererParamsNotNull(context, component);

        if (!shouldEncode(component)) {
            return;
        }

        final ResponseWriter writer = context.getResponseWriter();
        final HtmlFieldSet fieldSet = (HtmlFieldSet) component;

        final String style = fieldSet.getStyle();
        final String styleClass = fieldSet.getStyleClass();

        writer.startElement(ELEMENT_FIELDSET, component);

        this.writeIdAttributeIfNecessary(context, writer, component);

        if (null != style) {
            writer.writeAttribute(ATTRIBUTE_STYLE, style, "style");
        }
        if (null != styleClass) {
            writer.writeAttribute(ATTRIBUTE_CLASS, "butter-component-fieldset " + styleClass, "styleClass");
        } else {
            writer.writeAttribute(ATTRIBUTE_CLASS, "butter-component-fieldset", "styleClass");
        }


        if (StringUtils.isNotEmpty(fieldSet.getLabel())) {
            writer.startElement(ELEMENT_LEGEND, component);
            writer.writeText(fieldSet.getLabel(), component, "label");

            if (StringUtils.isNotEmpty(fieldSet.getBadgeText())) {
                writer.startElement(ELEMENT_SPAN, component);
                writer.writeAttribute(ATTRIBUTE_CLASS, "badge", null);
                writer.writeText(fieldSet.getBadgeText(), component, "badgeText");
                writer.endElement(ELEMENT_SPAN);
            }

            writer.endElement(ELEMENT_LEGEND);
        }
    }

    @Override
    public void encodeEnd(final FacesContext context, final UIComponent component) throws IOException {
        rendererParamsNotNull(context, component);

        if (!shouldEncode(component)) {
            return;
        }

        context.getResponseWriter().endElement(ELEMENT_FIELDSET);
    }

}