package Data;

import Data.PetSupplieDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import constructor.Pet_supplies;

public class ViewDetailsByCategory {
    private PetSupplieDB petSupplieDB;
    private DefaultListModel<String> listModel;
    private List<Pet_supplies> petSuppliesList;

    // Constructor to initialize the data source
    public ViewDetailsByCategory() {
        petSupplieDB = new PetSupplieDB();
        listModel = new DefaultListModel<>();
        petSuppliesList = new ArrayList<>();
    }

    // Method to load data from PetSupplieDB and populate the JList
    public void loadData(JList<String> jList, JTable jTable) {
        petSuppliesList = petSupplieDB.view();
        
        if (petSuppliesList != null) {
            for (Pet_supplies petSupplies : petSuppliesList) {
                // Add unique categories to the JList model
                if (!listModel.contains(petSupplies.getCategory())) {
                    listModel.addElement(petSupplies.getCategory());
                }
            }
        }
        
        // Set the list model for jList1
        jList.setModel(listModel);

        // Set up the JTable with empty data initially
        setupTable(jTable, new ArrayList<>());
    }

    // Method to handle item selection from JList and display filtered data in JTable
    public void handleSelection(JList<String> jList, JTable jTable) {
        jList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedCategory = jList.getSelectedValue();
                if (selectedCategory != null) {
                    List<String[]> filteredData = new ArrayList<>();
                    for (Pet_supplies petSupplies : petSuppliesList) {
                        if (petSupplies.getCategory().equals(selectedCategory)) {
                            // Add matching rows to filtered data
                            String[] row = {
                                petSupplies.getPet(),
                                petSupplies.getCategory(),
                                petSupplies.getColor(),
                                String.valueOf(petSupplies.getPrice()),
                                petSupplies.getBrand(),
                                petSupplies.getSize(),
                                petSupplies.getMetirial(),
                                petSupplies.getDiscription()
                            };
                            filteredData.add(row);
                        }
                    }
                    // Update the JTable with filtered data
                    setupTable(jTable, filteredData);
                }
            }
        });
    }

    // Method to populate the JTable
    private void setupTable(JTable jTable, List<String[]> data) {
        // Column names for the JTable
        String[] columns = {"Pet", "Category", "Color", "Price", "Brand", "Size", "Material", "Description"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        // Add rows to the table model
        for (String[] row : data) {
            tableModel.addRow(row);
        }

        // Set the new table model to jTable
        jTable.setModel(tableModel);
    }
}
