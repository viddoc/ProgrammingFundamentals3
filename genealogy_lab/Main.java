// Tommy Hudson Main.java for GenealogyTree Lab COSC-2436
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args) 
    {
        GenealogyTree tree = new GenealogyTree();
        buildTreeFromFile("genealogy.txt", tree);

        System.out.println("\nPrinting tree:");
        tree.printTree();
        System.out.println();

        ArrayList<ArrayList<TreeNode>> levels = levelOrderTraversal(tree.getRoot());
        for (int i = 0; i < levels.size(); i++) 
        {
            System.out.print("Level " + i + ": ");
            for (int j = 0; j < levels.get(i).size(); j++) 
            {
                if (j > 0) System.out.print(", ");
                System.out.print(levels.get(i).get(j).name);
            }
            System.out.println();
        }

        TreeNode ancestor = tree.findNode(tree.getRoot(), "Margaret Johnson");
        TreeNode descendant1 = tree.findNode(tree.getRoot(),"Charlotte Lee");
        TreeNode descendant2 = tree.findNode(tree.getRoot(),"Aria Carter");
        System.out.println();
        System.out.println("Is " + descendant1.name + " a descendant of " + ancestor.name + "? " + isDescendant(ancestor, descendant1));
        System.out.println("Is " + descendant2.name + " a descendant of " + ancestor.name + "? " + isDescendant(ancestor, descendant2));
    }
    /**
     * Method to build a tree from the genealogy file
     * @param filename Name of the file to read from
     * @param tree GenealogyTree to build
     */
    private static void buildTreeFromFile(String filename, GenealogyTree tree) 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(", ");
                String name = parts[0];
                String motherName = parts[1];
                int birthYear = Integer.parseInt(parts[2]);
                tree.addChild(name, motherName, birthYear);
            }
        } catch (IOException e) 
        {
            System.err.println("Failed to open file: " + filename);
        }
    }

    /**
     * Method to perform a level order traversal of a tree
     * @param root The root of the tree
     * @return ArrayList<ArrayList<TreeNode>> List of levels of the tree
     */
    private static ArrayList<ArrayList<TreeNode>> levelOrderTraversal(TreeNode root) 
    {
        ArrayList<ArrayList<TreeNode>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) 
        {
            int levelSize = queue.size();
            ArrayList<TreeNode> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) 
            {
                TreeNode node = queue.dequeue();
                level.add(node);
                for (TreeNode child : node.children) 
                {
                    queue.enqueue(child);
                }
            }
            levels.add(level);
        }
        return levels;
    }

    /**
     * Method to check if a node is a descendant of another node
     * @param ancestor The ancestor node to be checked against descendant
     * @param descendant The descendant node to be checked against ancestor
     * @return boolean Whether the descendant is a descendant of the ancestor
     */
    private static boolean isDescendant(TreeNode ancestor, TreeNode descendant) 
    {
        if (ancestor == null || descendant == null) return false;
        if (ancestor == descendant) return true;

        Stack stack = new Stack();
        stack.push(ancestor);

        while (!stack.isEmpty()) 
        {
            TreeNode node = stack.pop();
            for (TreeNode child : node.children) 
            {
                if (child == descendant) return true;
                stack.push(child);
            }
        }
        return false;
    }

}
