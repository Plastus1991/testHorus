package testyHorus;

import java.util.ArrayList;
import java.util.List;

public class CompositeBlockImpl implements CompositeBlock{


    private String color;
    private String material;
    private List<Block> blocks;

    public CompositeBlockImpl(String color, String material, List<Block> blocks) {
        this.color = color;
        this.material = material;
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {

        return blocks;

    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "CompositeBlockImpl{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", blocks=" + blocks +
                '}';
    }
}
