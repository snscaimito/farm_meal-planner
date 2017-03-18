package net.caimito.mealplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingApp extends JFrame {

	private static MealPlanner mealPlanner ;
	
	public static void main(String[] args) {
		SwingApp app = new SwingApp();
		app.prepareUI();
	}

	private void prepareUI() {
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		add(panel);
		placeComponents(panel);
		setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		/*
		 * We will discuss about layouts in the later sections of this tutorial.
		 * For now we are setting the layout to null
		 */
		panel.setLayout(null);

		final JLabel recipeURLLabel = new JLabel("Recipe URL");
		recipeURLLabel.setBounds(10, 20, 80, 25);
		panel.add(recipeURLLabel);

		final JTextField recipeURLText = new JTextField(140);
		recipeURLText.setBounds(100, 20, 400, 25);
		panel.add(recipeURLText);

		final JLabel resultLabel = new JLabel();
		resultLabel.setBounds(10, 50, 400, 25);
		panel.add(resultLabel);
		
		final JButton actionButton = new JButton("Retrieve");
		actionButton.setBounds(10, 80, 80, 25);
		actionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mealPlanner = new MealPlanner() ;
//				mealPlanner.addRecipeFrom(recipeURLText.getText()));
				resultLabel.setText("Retrieved");
			}
		});
		panel.add(actionButton);
	}
}
