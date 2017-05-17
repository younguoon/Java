
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Hyunwoo extends Frame {

   public static void main(String[] args) {

      new Hyunwoo(); // �͸����� ��ü ����� �ִ�.

   }
   // ����

   public Hyunwoo() {
      Panel panel_all = new Panel();

      panel_all.setLayout(new BorderLayout(0, 0));
      
      JPanel panel_top = new JPanel();
      panel_top.setBackground(Color.WHITE);
      panel_all.add(panel_top, BorderLayout.NORTH);
      panel_top.setLayout(new GridLayout(0, 2, 0, 0));
      
      JRadioButton btn_meal1 = new JRadioButton("\uC544\uCE68");
      btn_meal1.setHorizontalAlignment(SwingConstants.CENTER);
      panel_top.add(btn_meal1);
      
      JRadioButton btn_meal2 = new JRadioButton("\uC810\uC2EC");
      btn_meal2.setHorizontalAlignment(SwingConstants.CENTER);
      panel_top.add(btn_meal2);
      
      JRadioButton btn_meal3 = new JRadioButton("\uC800\uB141");
      btn_meal3.setHorizontalAlignment(SwingConstants.CENTER);
      panel_top.add(btn_meal3);
      
      JCheckBox btn_fruit1 = new JCheckBox("\uC0AC\uACFC");
      btn_fruit1.setHorizontalAlignment(SwingConstants.CENTER);
      panel_top.add(btn_fruit1);
      
      JCheckBox btn_fruit2 = new JCheckBox("\uBC14\uB098\uB098");
      btn_fruit2.setHorizontalAlignment(SwingConstants.CENTER);
      panel_top.add(btn_fruit2);
      
      JCheckBox btn_fruit3 = new JCheckBox("\uB538\uAE30");
      btn_fruit3.setHorizontalAlignment(SwingConstants.CENTER);
      btn_fruit3.setToolTipText("");
      panel_top.add(btn_fruit3);
      
      JPanel panel_center = new JPanel();
      panel_center.setBackground(Color.WHITE);
      panel_center.setForeground(Color.WHITE);
      panel_all.add(panel_center);
      
      JPanel panel_buttom = new JPanel();
      panel_buttom.setBackground(Color.WHITE);
      panel_all.add(panel_buttom, BorderLayout.SOUTH);
      
      Choice selection = new Choice();
      panel_buttom.add(selection);
      
      JButton btn_exit = new JButton("\uC885\uB8CC");
      panel_buttom.add(btn_exit);

//      super("������ ����"); // ȭ�� �����ִ� â �̸� ����
      // ��ġ��(�� >> �� �����ſ��� ū������ �ϴ°� ����.) �гο��ٰ� �۾��ϰ� �����ӿ��ٰ� ���δ�.

//      LayoutManager mgr = new BorderLayout();

      this.setLocation(300, 200);
      this.setSize(300, 400); // ���� ȭ�� ũ�⸦ �����ϰ� ���̱⸦ �ؾ��Ѵ�.
      this.setVisible(true); // true �� ���̰�, false �� ������ �ʴ´�.


   }


}