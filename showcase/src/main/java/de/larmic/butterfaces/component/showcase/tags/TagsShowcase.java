package de.larmic.butterfaces.component.showcase.tags;

import de.larmic.butterfaces.util.StringUtils;
import de.larmic.butterfaces.component.showcase.AbstractInputShowcase;
import de.larmic.butterfaces.component.showcase.example.AbstractCodeExample;
import de.larmic.butterfaces.component.showcase.example.XhtmlCodeExample;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class TagsShowcase extends AbstractInputShowcase implements Serializable {

    private String placeholder = "Enter text...";
    private String confirmKeys;
    private boolean autoFocus;
    private boolean distinct = true;
    private Integer maxTags;

    @Override
    protected Object initValue() {
        return null;
    }

    @Override
    public String getReadableValue() {
        return (String) this.getValue();
    }

    @Override
    public void buildCodeExamples(final List<AbstractCodeExample> codeExamples) {
        final XhtmlCodeExample xhtmlCodeExample = new XhtmlCodeExample(false);

        xhtmlCodeExample.appendInnerContent("        <b:tags id=\"input\"");
        xhtmlCodeExample.appendInnerContent("                label=\"" + this.getLabel() + "\"");
        xhtmlCodeExample.appendInnerContent("                hideLabel=\"" + isHideLabel() + "\"");
        xhtmlCodeExample.appendInnerContent("                value=\"" + this.getValue() + "\"");
        xhtmlCodeExample.appendInnerContent("                distinct=\"" + distinct + "\"");
        xhtmlCodeExample.appendInnerContent("                maxTags=\"" + maxTags + "\"");
        xhtmlCodeExample.appendInnerContent("                confirmKeys=\"" + StringUtils.getNotNullValue(confirmKeys, "") + "\"");
        xhtmlCodeExample.appendInnerContent("                placeholder=\"" + this.getPlaceholder() + "\"");
        xhtmlCodeExample.appendInnerContent("                styleClass=\"" + StringUtils.getNotNullValue(this.getStyleClass(), "")  + "\"");
        xhtmlCodeExample.appendInnerContent("                readonly=\"" + this.isReadonly() + "\"");
        xhtmlCodeExample.appendInnerContent("                disabled=\"" + this.isDisabled() + "\"");
        xhtmlCodeExample.appendInnerContent("                required=\"" + this.isRequired() + "\"");
        xhtmlCodeExample.appendInnerContent("                autoFocus=\"" + this.isAutoFocus() + "\"");
        xhtmlCodeExample.appendInnerContent("                rendered=\"" + this.isRendered() + "\">");

        this.addAjaxTag(xhtmlCodeExample, "change");

        if (this.isValidation()) {
            xhtmlCodeExample.appendInnerContent("            <f:validateLength minimum=\"2\" maximum=\"10\"/>");
        }

        if (StringUtils.isNotEmpty(getTooltip())) {
            xhtmlCodeExample.appendInnerContent("            <b:tooltip>");
            xhtmlCodeExample.appendInnerContent("                " + getTooltip());
            xhtmlCodeExample.appendInnerContent("            </b:tooltip>");
        }

        xhtmlCodeExample.appendInnerContent("        </b:tags>", false);

        this.addOutputExample(xhtmlCodeExample);

        codeExamples.add(xhtmlCodeExample);

        generateDemoCSS(codeExamples);
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(final String placeholder) {
        this.placeholder = placeholder;
    }

    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public Integer getMaxTags() {
        return maxTags;
    }

    public void setMaxTags(Integer maxTags) {
        this.maxTags = maxTags;
    }

    public String getConfirmKeys() {
        return confirmKeys;
    }

    public void setConfirmKeys(String confirmKeys) {
        this.confirmKeys = confirmKeys;
    }
}
