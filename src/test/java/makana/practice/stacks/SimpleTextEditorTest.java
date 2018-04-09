package makana.practice.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTextEditorTest {

    /**
     * 1 - append - Append string
     * 2 - delete - Delete the last k characters
     * 3 - print - Print the kth character
     * 4 - undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
     * 1 abc
     * 3 3
     * 2 3
     * 1 xy
     * 3 2
     * 4
     * 4
     * 3 1
     */
    @Test
    public void testEditor() {
        SimpleTextEditor editor = new SimpleTextEditor();
        editor.append("abc");
        assertEquals("c", editor.print(3));
        editor.delete(3);
        editor.append("xy");
        assertEquals("y", editor.print(2));
        editor.undo();
        editor.undo();
        assertEquals("a", editor.print(1));
    }

    @Test
    public void testAppend() {
        SimpleTextEditor editor = new SimpleTextEditor();
        editor.append("abc");
        assertEquals("a", editor.print(1));
        assertEquals("b", editor.print(2));
        assertEquals("c", editor.print(3));
    }

    @Test
    public void testDelete() {
        SimpleTextEditor editor = new SimpleTextEditor();
        editor.append("abc");
        editor.delete(1);
        assertEquals("ab", editor.toString());
        editor.delete(1);
        assertEquals("a", editor.toString());
    }

}