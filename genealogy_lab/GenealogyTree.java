// Tommy Hudson GenealogyTree.java for GenealogyTree Lab COSC-2436
import java.util.ArrayList;
import java.util.HashMap;
/**
 * GenealogyTree Class to act as a tree made up of TreeNode objects
 */
public class GenealogyTree 
{

    private TreeNode root;                      // Root of the tree 
    private HashMap<String, TreeNode> nodeMap;  // Map of names to nodes

    /**
     * Constructor for GenealogyTree
     */
    public GenealogyTree() 
    {
        this.root = null;
        this.nodeMap = new HashMap<>();
    }

    /**
     * Constructor for GenealogyTree
     * @param rootName Name of the root
     * @param rootBirthYear Birth year of the root
     */
    public GenealogyTree(String rootName, int rootBirthYear) 
    {
        this();
        addChild(rootName, "None", rootBirthYear);
    }

    /**
     * Method to add a child to the tree
     * @param childName Name of the child
     * @param parentName Name of the parent
     * @param birthYear Birth year of the child
     */
    public void addChild(String childName, String parentName, int birthYear) 
    {
        TreeNode childNode = new TreeNode(childName, birthYear);
        nodeMap.put(childName, childNode);

        if ("None".equals(parentName)) 
        {
            root = childNode;
        } 
        else 
        {
            TreeNode parentNode = nodeMap.get(parentName);
            if (parentNode != null) 
            {
                parentNode.children.add(childNode);
            }
        }
    }

    /**
     * Method to get the root of the tree
     * @return TreeNode Root of the tree
     */
    public TreeNode getRoot() 
    {
        return this.root;
    }

    /**
     * Method to find a node in the tree
     * @param start Starting node
     * @param name Name of the node to find
     * @return TreeNode Node with the given name
     */
    public TreeNode findNode(TreeNode start, String name) 
    {
        if (start == null) return null;
        if (name.equals(start.name)) return start;

        for (TreeNode child : start.children) 
        {
            TreeNode found = findNode(child, name);
            if (found != null) return found;
        }
        return null;
    }

    /**
     * Method to get the children of a node
     * @param motherName Name of the mother
     * @return ArrayList<TreeNode> List of children of the mother
     */
    public ArrayList<TreeNode> getChildren(String motherName) 
    {
        ArrayList<TreeNode> children = new ArrayList<>();
        TreeNode mother = nodeMap.get(motherName);
        if (mother != null) 
        {
            children.addAll(mother.children);
        }
        return children;
    }

    /**
     * Method to print the tree
     */
    public void printTree()
    {
        printSubTree(root, "", true);
    }
    /**
     * Method to print a subtree
     * @param node Node to start printing from
     * @param prefix Prefix to print
     * @param isLast Whether the node is the last in the list
     */
    private void printSubTree(TreeNode node, String prefix, boolean isLast) 
    {
        if (node == null) return;

        System.out.print(prefix);

        if (!prefix.isEmpty()) 
        {
            System.out.print(isLast ? "|__ " : "|-- ");
        }

        System.out.println(node.name + " (" + node.birthYear + ")");

        for (int i = 0; i < node.children.size(); i++) 
        {
            printSubTree(node.children.get(i), prefix + (isLast ? "    " : "|   "), i == node.children.size() - 1);
        }
    }
}
