package fiuba.navalgo.view;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fiuba.navalgo.model.naves.*;

public class RenderCelda extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if( value instanceof Lancha )
        {
            cell.setBackground(Color.MAGENTA);
              
        }
        if( value instanceof Buque )
        {
            cell.setBackground(Color.GREEN);
              
        }
        if( value instanceof Destructor )
        {
            cell.setBackground(Color.CYAN);
              
        }
        if( value instanceof PortaAviones )
        {
            cell.setBackground(Color.YELLOW);
              
        }
        if( value instanceof RompeHielos)
        {
            cell.setBackground(Color.RED);
              
        }
        if( value instanceof PorcionDeNave)
        {
            cell.setBackground(Color.BLACK);
              
        }
        return cell;
    }
}