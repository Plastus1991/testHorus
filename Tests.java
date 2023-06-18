package testyHorus;

import java.util.Arrays;
import java.util.List;

public class Tests {

    public static void main(String[] args) {

        BlockImpl block1 = new BlockImpl("color1", "material1");
        BlockImpl block2 = new BlockImpl("color4", "material2");
        BlockImpl block3 = new BlockImpl("color4", "material3");
        BlockImpl block4 = new BlockImpl("color4", "material4");
        List<Block> list4 = Arrays.asList(block1, block2);
        CompositeBlockImpl compositeBlock3 = new CompositeBlockImpl("color7", "material7", list4);
        List<Block> list1 = Arrays.asList(compositeBlock3, compositeBlock3);
        CompositeBlockImpl compositeBlock1 = new CompositeBlockImpl("color7", "material7", list1);
        List<Block> list2 = Arrays.asList(block3, block4, compositeBlock1);
        CompositeBlockImpl compositeBlock2 = new CompositeBlockImpl("color8", "material8", list2);

        List<Block> list3 = Arrays.asList(compositeBlock2);

        Wall wall = new Wall(list3);


        System.out.println("Number of blocks: " + wall.count());
        System.out.println("Blocks by color: " + wall.findBlockByColor("color4"));
        System.out.println("Blocks by material: " + wall.findBlocksByMaterial("material2"));
        System.out.println("CompositeBlocks: " + wall.getAllCompositeBlock(list3).size());






    }
}
