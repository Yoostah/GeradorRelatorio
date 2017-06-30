
package z_ux;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class JTableUtilities
{
    public static void alinharColuna(JTable table, int alignment, int row)
    {
        DefaultTableCellRenderer alinhamento = new DefaultTableCellRenderer();
        alinhamento.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        
        table.getColumnModel().getColumn(row).setCellRenderer(alinhamento);
        
    }
    
    public static void centralizarHeader(JTable table)
    {
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);


    }
    
}
