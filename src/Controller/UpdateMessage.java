package Controller;

public class UpdateMessage implements Message {
    public int[] heights;

    public UpdateMessage(int[] heights){
      this.heights = heights;
    }

    public int[] getHeights(){
        return heights;
    }
}