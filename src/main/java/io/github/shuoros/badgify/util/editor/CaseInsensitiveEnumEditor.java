package io.github.shuoros.badgify.util.editor;

import java.beans.PropertyEditorSupport;

public class CaseInsensitiveEnumEditor extends PropertyEditorSupport {

    private final Class<? extends Enum> enumType;
    private final String[] enumNames;

    public CaseInsensitiveEnumEditor(Class<?> type) {
        this.enumType = type.asSubclass(Enum.class);
        var values = type.getEnumConstants();
        if (values == null) {
            throw new IllegalArgumentException("Unsupported " + type);
        }
        this.enumNames = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            this.enumNames[i] = ((Enum<?>) values[i]).name();
        }
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            setValue(null);
            return;
        }
        for (String n : enumNames) {
            if (n.equalsIgnoreCase(text)) {
                @SuppressWarnings("unchecked")
                var newValue = Enum.valueOf(enumType, n);
                setValue(newValue);
                return;
            }
        }
        throw new IllegalArgumentException("No enum constant " + enumType.getCanonicalName() + " equals ignore case " + text);
    }
}
