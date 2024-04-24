import java.util.*;

public class CourseGradebook extends Gradebook 
{
   // Protected member variables
   // gradebook is a HashMap that maps an assignment name to a HashMap that maps a student ID to the student's corresponding score for that assignment
   protected HashMap<String, HashMap<Integer, Double>> gradebook = new HashMap<>();



   // Implement all abstract methods here

	/**
	 * Returns a HashMap that maps a student ID to the student's corresponding score for the specified assignment
	 * @param assignmentName the name of the assignment
	 * @return a HashMap that maps a student ID to the student's corresponding score for the specified assignment
	 */
	@Override
	public HashMap<Integer, Double> getAssignmentScores(String assignmentName) 
	{
		// HashMap with the studentID as the key and the score as the value that is pulled from the gradebook
		HashMap <Integer, Double> scoreMap = gradebook.get(assignmentName);
		// If the assignment does not exist in the gradebook, return null otherwise return the scoreMap
		if(scoreMap == null)
		{
			return null;
		}
		return scoreMap;
	}
	/**
	 * Returns the specified student's score for the specified assignment
	 * @param assignmentName the name of the assignment
	 * @param studentID the student's ID
	 * @return student's score for the assignment
	 */
	@Override
	public double getScore(String assignmentName, Integer studentID) 
	{
		// HashMap with the studentID as the key and the score as the value
		HashMap <Integer, Double> scoreMap = gradebook.get(assignmentName);
		// If the assignment does not exist in the gradebook, or the assignment exists but no score exists for the specified student, return NaN
		if(scoreMap == null)
		{
			return Double.NaN;
		}
		else
		{
			// Get the score for the specified student
			Double score = scoreMap.get(studentID);
			// If the assignment exists but no score exists for the specified student, return NaN
			if(score == null)
			{
				return Double.NaN;
			}
			// Else, return the score
			else
			{
				return score;
			}
		}

	}
	/**
	 * Returns an ArrayList with all distinct assignment names, sorted in ascending order
	 * @return an ArrayList with all distinct assignment names, sorted in ascending order
	 */
	@Override
	public ArrayList<String> getSortedAssignmentNames() 
	{
		// Create an ArrayList to store the assignment names
		ArrayList<String> assignmentNames = new ArrayList<String>();
		// Iterate through the keys in the gradebook and add the assignment names to the ArrayList
		for(String assignmentName : gradebook.keySet())
		{
			assignmentNames.add(assignmentName);
		}
		// Sort the ArrayList in ascending order and return it
		Collections.sort(assignmentNames);
		return assignmentNames;

	}
	/**
	 * Returns an ArrayList with all distinct student IDs, sorted in ascending order
	 * @return an ArrayList with all distinct student IDs, sorted in ascending order
	 */
	@Override
	public ArrayList<Integer> getSortedStudentIDs() 
	{
		// Create an ArrayList to store the student IDs
		ArrayList<Integer> studentIDs = new ArrayList<Integer>();
		// Create a HashSet to store the student IDs
		HashSet<Integer> studentIDSet = new HashSet<Integer>();
		// Iterate through the keys in the gradebook and add the student IDs to the HashSet
		for( HashMap <Integer, Double> scoreMap : gradebook.values())
		{
			studentIDSet.addAll(scoreMap.keySet());
		}
		// Add the student IDs from the HashSet to the ArrayList
		studentIDs.addAll(studentIDSet);
		// Sort the ArrayList in ascending order and return it
		Collections.sort(studentIDs);
		return studentIDs;
	}
	/**
	 * Gets all scores that exist in the gradebook for the studentID passed
	 * @param studentID the studentID to get the scores for
	 * @return a HashMap that maps an assignment name to the student's corresponding score for that assignment
	 */
	@Override
	public HashMap<String, Double> getStudentScores(Integer studentID) 
	{
		HashMap<String, Double> studentScores = new HashMap<String, Double>();
		// Iterate through the keys in the gradebook
		for(String assignmentName : gradebook.keySet())
		{
			// Get the score for the specified student
			Double score = gradebook.get(assignmentName).get(studentID);
			// If the score is not null, add the score to the HashMap
			if(score != null)
			{
				studentScores.put(assignmentName, score);
			}
		}
		
		return studentScores;
	}
	/**
	 * Adds or updates a score in the gradebook.
	 * @param assignmentName the name of the assignment
	 * @param studentID the student's ID
	 * @param score the student's score
	 */
	@Override
	public void setScore(String assignmentName, Integer studentID, Double score) 
	{
		// HashMap with the studentID as the key and the score as the value that is stored in the gradebook
		HashMap <Integer, Double> scoreMap = gradebook.get(assignmentName);
		// If the assignment does not exist in the gradebook, create a new HashMap and add the score to the gradebook
		if(scoreMap == null)
		{
			scoreMap = new HashMap<Integer, Double>();
			scoreMap.put(studentID, score);
			gradebook.put(assignmentName, scoreMap);
		}
		// Else, modify the score in the gradebook
		else
		{
			scoreMap.put(studentID, score);
		}
	}
}