package renthelper.core.layout;//使用子类GBC简化GridBagConstraints对象的操作
//使用实例：GridBagPanes.java

import java.awt.*;

public class GBC extends GridBagConstraints{
    //初始化左上角的坐标值
    public GBC(int gridx, int gridy){
        this.gridx = gridx;
        this.gridy = gridy;
    }
    
    //初始化左上角位置和所占行数和列数
    public GBC(int gridx, int gridy, int gridwidth, int gridheight){
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }
    
    //对齐方式
    public GBC setAnchor(int anchor){
        this.anchor = anchor;
        return this;
    }
    
    //是否拉伸及拉伸方向
    public GBC setFill(int fill){
        this.fill = fill;
        return this;
    }
    
    //x和y方向上的增量
    public GBC setWeight(double weightx, double weighty){
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
    
    //外部填充
    public GBC setInsets(int distance){
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }
    
    //外部填充
    public GBC setInsets(int top, int left, int bottom, int right){
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }
    
    //内部填充
    public GBC setIpad(int ipadx, int ipady){
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
