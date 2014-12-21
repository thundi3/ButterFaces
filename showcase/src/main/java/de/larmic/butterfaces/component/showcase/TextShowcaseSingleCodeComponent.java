package de.larmic.butterfaces.component.showcase;

import de.larmic.butterfaces.component.partrenderer.StringUtils;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class TextShowcaseSingleCodeComponent extends AbstractInputShowcaseSingleCodeComponent implements Serializable {

    private String placeholder = DEFAULT_TEXT_PLACEHOLDER;
    private String type;
    private String pattern;
    private String min;
    private String max;
    private boolean autoFocus;

    @Override
    protected Object initValue() {
        return null;
    }

    @Override
    public String getReadableValue() {
        return (String) this.getValue();
    }

    @Override
    public String getXHtml() {
        final StringBuilder sb = new StringBuilder();

        this.addXhtmlStart(sb);

        sb.append("        <b:text id=\"input\"\n");
        sb.append("                label=\"" + this.getLabel() + "\"\n");
        sb.append("                value=\"" + this.getValue() + "\"\n");

        this.appendString("tooltip", this.getTooltip(), sb);
        this.appendString("placeholder", this.getPlaceholder(), sb);
        this.appendString("type", this.getType(), sb);
        this.appendString("pattern", this.getPattern(), sb);
        this.appendString("min", this.getMin(), sb);
        this.appendString("max", this.getMax(), sb);
        this.appendString("styleClass", this.getStyleClass(), sb);
        this.appendString("inputStyleClass", this.getInputStyleClass(), sb);
        this.appendString("labelStyleClass", this.getLabelStyleClass(), sb);

        this.appendBoolean("readonly", this.isReadonly(), sb);
        this.appendBoolean("required", this.isRequired(), sb);
        this.appendBoolean("autoFocus", this.isAutoFocus(), sb);
        this.appendBoolean("rendered", this.isRendered(), sb, true);

        this.createAjaxXhtml(sb, "keyup");

        if (this.isValidation()) {
            sb.append("            <f:validateLength minimum=\"2\" maximum=\"10\"/>\n");
        }
        sb.append("        </b:text>");

        this.createOutputXhtml(sb);

        this.addXhtmlEnd(sb);

        return sb.toString();
    }

    @Override
    protected void addCss(StringBuilder sb) {
        if (!StringUtils.isEmpty(this.getStyleClass())) {
            sb.append(".some-demo-class {\n");
            sb.append("    background-color: red;\n");
            sb.append("}");
        }
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(final String placeholder) {
        this.placeholder = placeholder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}