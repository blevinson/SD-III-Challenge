import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String args[])
    {
        // input string
        String input = "null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid";

        // use | delimiter to make string into an array
        String[] stringArray = input.split("\\|");

        // get root node info from the first item in array
        String[] inputRootArray = stringArray[0].split(",");

        // set root node info
        Tree<Integer, String> tree =
                new Tree<>(Integer.parseInt(inputRootArray[1]), inputRootArray[2]);

        // convert to LinkedList to remove first item
        List<String> restOfNodes = new LinkedList<>(Arrays.asList(stringArray));
        restOfNodes.remove(0);


        // iterate through the rest of the array
        for (String each : restOfNodes) {
            String[] inputArray = each.split(",");

            // add children nodes
            tree.addChild( Integer.parseInt(inputArray[0]),
                    Integer.parseInt(inputArray[1]), inputArray[2]);
        }

        // print family tree
        System.out.println(tree.subtreeToString(0));

       }

    }
