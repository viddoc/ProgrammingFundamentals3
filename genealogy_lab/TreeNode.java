// Tommy Hudson TreeNode.java for GenealogyTree Lab COSC-2436
import java.util.ArrayList;

/**
 * TreeNode Class to act as a node to hold data in a tree for the GenealogyTree lab.
 */
public class TreeNode 
{
    String name;                    // Name of the person
    int birthYear;                  // Birth year of the person
    ArrayList<TreeNode> children;   // List of children of the person

    /**
     * Constructor for TreeNode
     * @param name Name of the person
     * @param birthYear Birth year of the person
     */
    public TreeNode(String name, int birthYear) 
    {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

}
