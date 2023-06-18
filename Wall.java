package testyHorus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> optBlock = Optional.empty();
        List<Block> allBlocks = getAllBlocksRec(blocks);
        for (Block block : allBlocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return optBlock;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> foundBlocks = new ArrayList<>();
        List<Block> allBlocks = getAllBlocksRec(blocks);
        for (Block block : allBlocks) {
            if (block.getMaterial().equals(material)) {
                foundBlocks.add(block);
            }
        }
        return foundBlocks;
    }

    @Override
    public int count() {
        return getAllBlocksRec(blocks).size();
    }

    private List<Block> getAllBlocksRec(List<Block> blockList) {
        List<Block> allBlocks = new ArrayList<>();
        for (Block block : blockList) {
            if (block instanceof CompositeBlock) {
                allBlocks.addAll(getAllBlocksRec(((CompositeBlock) block).getBlocks()));
            } else {
                allBlocks.add(block);
            }
        }
        return allBlocks;
    }

    public List<Block> getAllCompositeBlock(List<Block> blockList) {
        List<Block> allCompositeBlocks = new ArrayList<>();

        for (Block block : blockList) {

            if (block instanceof CompositeBlock) {
                allCompositeBlocks.add(block);
                allCompositeBlocks.addAll(getAllCompositeBlock(((CompositeBlock) block).getBlocks()));
            }
        }

        return allCompositeBlocks;
    }
}

